/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state;

/**
 * @author windows
 * 
 */
public interface ApplianceStateBehavior {

	/**
	 * Return the the state this behavior represents
	 * 
	 * @return the the state this behavior represents
	 */
	ApplianceState getState();

	/**
	 * Behavior start delegated on this object
	 * @return the new state if applicable, this otherwise
	 */
	ApplianceStateBehavior start();

	/**
	 * Behavior stop delegated on this object
	 * @return the new state if applicable, this otherwise
	 */
	ApplianceStateBehavior stop();

	/**
	 * Behavior tunrOn delegated on this object
	 * @return the new state if applicable, this otherwise
	 */
	ApplianceStateBehavior turnOn();

	/**
	 * Behavior off delegated on this object
	 * @return the new state if applicable, this otherwise
	 */
	ApplianceStateBehavior turnOff();

}
