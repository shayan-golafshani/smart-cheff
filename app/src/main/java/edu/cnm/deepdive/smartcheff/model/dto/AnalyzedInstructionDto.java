package edu.cnm.deepdive.smartcheff.model.dto;

import com.google.gson.annotations.Expose;
import java.util.List;

/**
 * This class is a DTO object for storing data from the Spoonacular api.
 */
public class AnalyzedInstructionDto {

  /**
   * This field is the name of the recipe that the instructions corresponds to.
   */
  @Expose
  private String name;

  /**
   * This field is a list of steps in the instructions.
   */
  @Expose
  private List<StepDto> steps;

  /**
   * Gets the name of the recipe that the instructions corresponds to.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the recipe that the instructions corresponds to.
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the list of steps.
   */
  public List<StepDto> getSteps() {
    return steps;
  }

  /**
   * Sets the list of steps.
   */
  public void setSteps(List<StepDto> stepDtos) {
    this.steps = stepDtos;
  }
}
