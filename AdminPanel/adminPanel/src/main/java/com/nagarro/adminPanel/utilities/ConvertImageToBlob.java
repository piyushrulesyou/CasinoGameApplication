package com.nagarro.adminPanel.utilities;

import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * This class converts the uploaded image into blob to be saved in database.
 * 
 * @author piyushagarwal01
 *
 */
public class ConvertImageToBlob {

	/**
	 * This method converts the image to blob object.
	 * 
	 * @param idProof
	 * @return The blob of the idProof.
	 */
	public static Blob convertImageToBlob(CommonsMultipartFile idProof) {
		byte[] idProofContent = idProof.getBytes();
		Blob idProofBlob = null;
		try {
			idProofBlob = new SerialBlob(idProofContent);
		} catch (SerialException e) {
//			LOG.error("SerialException : ", e);
		} catch (SQLException e) {
//			LOG.error("SQLException : ", e);
		}

		return idProofBlob;
	}
}
