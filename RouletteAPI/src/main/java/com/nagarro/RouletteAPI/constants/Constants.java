package com.nagarro.RouletteAPI.constants;

/**
 * This class contains the constants used in the complete project.
 * 
 * @author piyushagarwal01
 *
 */
public class Constants {
	public static final String uriValidateUser = "http://localhost:8085/adminPanel/customerdetails/{customerID}";

	public static final String uriBlockAmount = "http://localhost:8085/adminPanel/blockPlayAmount/{customerID}/{blockAmount}";

	public static final String uriUpdateUserAccount = "http://localhost:8085/adminPanel/adjustFinal/{customerID}/{finalAmountWonLost}";

}
