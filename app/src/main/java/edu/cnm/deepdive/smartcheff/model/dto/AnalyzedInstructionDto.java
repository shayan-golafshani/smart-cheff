package edu.cnm.deepdive.smartcheff.model.dto;

import com.google.gson.annotations.Expose;
import java.util.List;

public class AnalyzedInstructionDto {

  @Expose
  private String name;

  @Expose
  private List<StepDto> steps;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<StepDto> getSteps() {
    return steps;
  }

  public void setSteps(List<StepDto> stepDtos) {
    this.steps = stepDtos;
  }
}
