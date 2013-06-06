/*
 ~ Copyright (c) 2013, WSO2Mobile Inc. (http://www.wso2mobile.com) All Rights Reserved.
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~      http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
*/
package com.mdm;

import android.app.admin.DevicePolicyManager;
import android.content.Context;

public class DeviceAffectedFeatures {
	DevicePolicyManager devicePolicyManager;
	static final int ACTIVATION_REQUEST = 47; 
	Context context;
	
	public DeviceAffectedFeatures(Context contex){
		this.context = context;
	}
	void lockDevice(){
	//	devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
	}
	void resetPassword(){
		
	}
	void wipeData(){
		
	}
	
}
