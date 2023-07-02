package model.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * The intent for this class is to update/store information about a single farmer
 */
@AllArgsConstructor
@Builder
@Getter
public class FarmerModel {
    private final int farmerID;
    private final String fullName;
    private final int yearsOfEmployment;
    private final int salary;
}
