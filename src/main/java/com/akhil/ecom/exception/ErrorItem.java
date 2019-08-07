package com.akhil.ecom.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
/**
 * 
 * @author akhil
 *
 */
public class ErrorItem {

        @JsonInclude(JsonInclude.Include.NON_NULL) private String code;

        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }