package com.igor.meetingpolls.service;

import com.igor.meetingpolls.constants.Constants;
import com.igor.meetingpolls.exception.ForbiddenException;
import com.igor.meetingpolls.exception.ResourceNotFoundException;
import com.igor.meetingpolls.model.validation.CpfValidatorResponse;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CpfValidatorServiceImpl implements CpfValidatorService {

    @Override
    public boolean isValidCpf(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            CpfValidatorResponse response = restTemplate.getForObject(Constants.CPI_VALIDATOR_URL, CpfValidatorResponse.class, cpf);
            log.info("The associate with CPF: {} is {}", cpf, response.getStatus());
            return Constants.ABLE_TO_VOTE.equals(response.getStatus());
        } catch (Exception e) {
            throw new ForbiddenException("The CPF " + cpf + " is not valid.");
        }
    }

}
