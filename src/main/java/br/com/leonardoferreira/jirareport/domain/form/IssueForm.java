package br.com.leonardoferreira.jirareport.domain.form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class IssueForm {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "Data inicial não pode ser vazia.")
    private Date startDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "Data final não pode ser vazia.")
    private Date endDate;

    private List<String> keys;

    private List<String> systems;

    private List<String> taskSize;
}