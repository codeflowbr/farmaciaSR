package com.codeflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WhatsappDTO {
	
    private String apikey;
    private String phone_number;
    private String contact_phone_number;
    private String message_custom_id;
    private String message_type;
    private String message_body;

}
