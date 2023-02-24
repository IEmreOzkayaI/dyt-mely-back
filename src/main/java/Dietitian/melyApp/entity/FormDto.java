package Dietitian.melyApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormDto {
    private String nameSurname;
    private String gender;
    private String job;
    private String email;
    private String phoneNumber;
    private String age;
    private String weight;
    private String height;

    private String disaster;
    private String familyDisaster;
    private String medic;
    private String operation;
    private String allergie;
    private String morningTime;
    private String nightTime;
    private String regl;

    private String toilet;
    private String digestiveProblem;
    private String badDrink;
    private String badFood;
    private String currentDailyMealAmount;
    private String passedMeal;
    private String currentDailySnackAmount;
    private String possibleDailyMealAmount;
    private String essentialFood;
    private String unlikedFood;
    private String fastEat;
    private String cheatAmount;
    private String cheatReason;

    // Daily Drink

    private String water;
    private String tea;
    private String coffee;
    private String mineralWater;
    private String fizzyDrink;
    private String cigaratte;
    private String alcohol;
    private String ayran;
    private String milk;


    // weight gain loss history
    private String whenGainLoss;
    private String highestWeight;
    private String lowestWeight;
    private String weightGainLostCause;
    private String wereCurrentDietBefore;
    private String goalWeight;

    // training information
    private String fitness;
    private String cardio;
    private String functional;


    private String trainerName;
    private String dailyStep;
    private String sportHistory;

    private String specialNote;

}

