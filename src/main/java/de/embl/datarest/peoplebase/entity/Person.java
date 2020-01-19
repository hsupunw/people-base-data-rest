package de.embl.datarest.peoplebase.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.embl.datarest.peoplebase.constants.ExampleValues;
import de.embl.datarest.peoplebase.converter.HobbyConverter;
import de.embl.datarest.peoplebase.exception.MandatoryFieldException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Entity
@Audited
@Data
public class Person {
    @Id
    @ApiModelProperty(hidden = true)
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @ApiModelProperty(hidden = true)
    private Date modified;
    @Column(nullable = false)
    @ApiModelProperty(required = true, notes = "first name of the person", example = ExampleValues.FIRST_NAME)
    @JsonProperty("first_name")
    private String firstName;
    @ApiModelProperty(notes = "last name of the person", example = ExampleValues.LAST_NAME)
    @JsonProperty("last_name")
    private String lastName;
    @ApiModelProperty(notes = "age of the person in years", example = ExampleValues.AGE)
    private Integer age;
    @ApiModelProperty(notes = "favourite colour of the person", example = ExampleValues.FAVOURITE_COLOUR)
    @JsonProperty("favourite_colour")
    private String favouriteColour;
    @Convert(converter = HobbyConverter.class)
    @Column(length = 3000)
    @ApiModelProperty(notes = "hobbies of the person", example = ExampleValues.HOBBIES)
    private Collection<String> hobby;

    @PrePersist
    public void validateAndSetId() {
        if (firstName == null || firstName.isEmpty()) {
            throw new MandatoryFieldException("first name can't be empty");
        }
        if (id == null || id.isEmpty()) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
