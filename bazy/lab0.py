import pandas as pd

data = pd.read_csv("menagerie.csv", sep=';')
question = 1

def print_question():
    global question
    print()
    print('Pytanie nr', question)
    question += 1
print_question()
x = data[['owner', 'name']]
for index, row in x.iterrows():
	print('Wlasciciel:', row['owner'], 'imie:', row['name'])

print_question()
x = x.sort_values('name', ascending=False)
for index, row in x.iterrows():
	print('Wlasciciel:', row['owner'], 'imie:', row['name'])

print_question()
indexes = pd.to_datetime(data['birth']).dt.dayofyear <= (365 + pd.to_datetime(data['birth']).dt.is_leap_year)/2
x = data[indexes]
for index, row in x.iterrows():
	print('imie:', row['name'])

print_question()
x = data.groupby('owner').filter(lambda g: len(g) > 1).groupby('owner').size().items()
for name, count in x:
    print(name)

print_question()
x = data.groupby('species').size().items()
for name, count in x:
    print(name, ':', count)

print_question()
x = data[(data.species == 'cat') & (data.type == 'litter')]
x = x['owner'].unique()
for owner in x:
    print(owner)

newData = [('Alex','Bob', 'dog', 'f', '04.06.1992', '\\N', '04.06.1992', 'birthday', '\\N'),
           ('Rex','Bob', 'dog', 'f', '03.07.1994', '\\N', '03.07.1994', 'birthday', '\\N'),
           ('Dylan','Alice', 'hamster', 'f', '24.04.1995', '\\N', '24.04.1995', 'birthday', '\\N'),
           ('Alex','Joe', 'sheep', 'f', '14.02.1996', '\\N', '14.02.1996', 'birthday', '\\N'),
           ('Alex','Joe', 'goat', 'f', '03.07.1994', '\\N', '03.07.1994', 'birthday', '\\N'),
           ('Zoe','Joe', 'goat', 'f', '03.07.1994', '\\N', '03.07.1994', 'birthday', '\\N'),
           ('Bobby','Joe', 'goat', 'f', '03.07.1994', '\\N', '03.07.1994', 'birthday', '\\N')]
dfnewData = pd.DataFrame(newData, columns = data.columns)
x = data.append(dfnewData).reset_index(drop=True)
x.to_csv('menagerie2.csv', sep=';', index=False)
