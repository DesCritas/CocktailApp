package com.descritas.cocktailapp.dto

import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("idDrink")
    val id: Long, // NotNull
    @SerializedName("strDrink")
    val name: String, // NotNull
    // "strDrinkAlternate": null,
    // "strTags": null,
    // "strVideo": null,
    @SerializedName("strCategory")
    val category: String, // NotNull
    // "strIBA": null,
    @SerializedName("strAlcoholic")
    val type: String, // NotNull
    @SerializedName("strGlass")
    val glass: String, // NotNull
    @SerializedName("strInstructions")
    val instruction: String, // NotNull
    // "strInstructionsES": null,
    // "strInstructionsDE": null,
    // "strInstructionsFR": null,
    // "strInstructionsIT": null,
    // "strInstructionsZH-HANS": null,
    // "strInstructionsZH-HANT": null,
    @SerializedName("strDrinkThumb")
    val imgThumbLink: String, // "https://www.thecocktaildb.com/images/media/drink/8cl9sm1582581761.jpg"
    @SerializedName("strIngredient1")
    val ingr1: String, // NotNull
    @SerializedName("strIngredient2")
    val ingr2: String?, // Nullable
    @SerializedName("strIngredient3")
    val ingr3: String?, // Nullable
    @SerializedName("strIngredient4")
    val ingr4: String?, // Nullable
    @SerializedName("strIngredient5")
    val ingr5: String?, // Nullable
    @SerializedName("strIngredient6")
    val ingr6: String?, // Nullable
    @SerializedName("strIngredient7")
    val ingr7: String?, // Nullable
    @SerializedName("strIngredient8")
    val ingr8: String?, // Nullable
    @SerializedName("strIngredient9")
    val ingr9: String?, // Nullable
    @SerializedName("strIngredient10")
    val ingr10: String?, // Nullable
    @SerializedName("strIngredient11")
    val ingr11: String?, // Nullable
    @SerializedName("strIngredient12")
    val ingr12: String?, // Nullable
    @SerializedName("strIngredient13")
    val ingr13: String?, // Nullable
    @SerializedName("strIngredient14")
    val ingr14: String?, // Nullable
    @SerializedName("strIngredient15")
    val ingr15: String?, // Nullable

    @SerializedName("strMeasure1")
    val measure1: String, // NotNull
    @SerializedName("strMeasure2")
    val measure2: String?, // Nullable
    @SerializedName("strMeasure3")
    val measure3: String?, // Nullable
    @SerializedName("strMeasure4")
    val measure4: String?, // Nullable
    @SerializedName("strMeasure5")
    val measure5: String?, // Nullable
    @SerializedName("strMeasure6")
    val measure6: String?, // Nullable
    @SerializedName("strMeasure7")
    val measure7: String?, // Nullable
    @SerializedName("strMeasure8")
    val measure8: String?, // Nullable
    @SerializedName("strMeasure9")
    val measure9: String?, // Nullable
    @SerializedName("strMeasure10")
    val measure10: String?, // Nullable
    @SerializedName("strMeasure11")
    val measure11: String?, // Nullable
    @SerializedName("strMeasure12")
    val measure12: String?, // Nullable
    @SerializedName("strMeasure13")
    val measure13: String?, // Nullable
    @SerializedName("strMeasure14")
    val measure14: String?, // Nullable
    @SerializedName("strMeasure15")
    val measure15: String?, // Nullable*/

    // val imgLink: String,//"https://www.thecocktaildb.com/drink/11415"

    val likedByMe: Boolean,
    // "strImageAttribution": null,
    // "strCreativeCommonsConfirmed": "Yes",
    // "dateModified": "2017-09-08 16:10:40"
)
