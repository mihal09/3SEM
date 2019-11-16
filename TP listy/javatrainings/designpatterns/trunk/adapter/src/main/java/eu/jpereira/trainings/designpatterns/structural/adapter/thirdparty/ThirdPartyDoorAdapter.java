package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;


public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door {

    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            this.unlock(code);
            this.setState(DoorState.OPEN);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
        }
    }

    @Override
    public void close() {
        try {
            this.setState(DoorState.CLOSED);
            this.lock();
        } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
            cannotChangeStateOfLockedDoor.printStackTrace();
        }
    }

    @Override
    public boolean isOpen() {
        return this.getState()==DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        try {
            this.unlock(oldCode);
        } catch (CannotUnlockDoorException e) {
            throw new IncorrectDoorCodeException();
        }
        if(newCode != newCodeConfirmation)
            throw new CodeMismatchException();
        else {
            try {
                this.setNewLockCode(newCode);
            } catch (CannotChangeCodeForUnlockedDoor cannotChangeCodeForUnlockedDoor) {

            }
        }
    }

    @Override
    public boolean testCode(String code) {
        LockStatus previousLockStatus = this.getLockStatus();
        try {
            this.unlock(code);
        } catch (CannotUnlockDoorException e) {
            return false;
        }
        if(previousLockStatus==LockStatus.LOCKED)
            this.lock();
        return true;
    }
}