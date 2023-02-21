package com.descritas.cocktailapp.dto

import com.google.gson.annotations.SerializedName

data class Card (
    @SerializedName("idDrink")
    val id: Long,//NotNull
    @SerializedName("strDrink")
    val name: String,//NotNull
    //"strDrinkAlternate": null,
    //"strTags": null,
    //"strVideo": null,
    @SerializedName("strCategory")
    val category: String,//NotNull
    //"strIBA": null,
    @SerializedName("strAlcoholic")
    val type: String,//NotNull
    @SerializedName("strGlass")
    val glass: String,//NotNull
    @SerializedName("strInstructions")
    val instruction: String,//NotNull
    //"strInstructionsES": null,
    //"strInstructionsDE": "Puderzucker in einer Mischung aus Wasser und Zitronensaft auflösen. Gin hinzufügen. In ein old-fashioned Glas über Eiswürfel gießen und umrühren. Die  Orangenspirale hinzufügen und servieren.",
    //"strInstructionsFR": null,
    //"strInstructionsIT": "Sciogliere lo zucchero a velo in una miscela di acqua e succo di limone. Aggiungi il gin. Versare in un bicchiere vecchio stile con dei cubetti di ghiaccio e mescolare.Aggiungere la scorza d'arancia e servire.",
    //"strInstructionsZH-HANS": null,
    //"strInstructionsZH-HANT": null,
    @SerializedName("strDrinkThumb")
    val imgThumbLink: String,//"https://www.thecocktaildb.com/images/media/drink/8cl9sm1582581761.jpg"
    /*val ingr1: String,//NotNull
    val ingr2: String?,//Nullable
    val ingr3: String?,//Nullable
    val ingr4: String?,//Nullable
    val ingr5: String?,//Nullable
    val ingr6: String?,//Nullable
    val ingr7: String?,//Nullable
    val ingr8: String?,//Nullable
    val ingr9: String?,//Nullable
    val ingr10: String?,//Nullable
    val ingr11: String?,//Nullable
    val ingr12: String?,//Nullable
    val ingr13: String?,//Nullable
    val ingr14: String?,//Nullable
    val ingr15: String?,//Nullable*/

    /*val measure1: String,//NotNull
    val measure2: String?,//Nullable
    val measure3: String?,//Nullable
    val measure4: String?,//Nullable
    val measure5: String?,//Nullable
    val measure6: String?,//Nullable
    val measure7: String?,//Nullable
    val measure8: String?,//Nullable
    val measure9: String?,//Nullable
    val measure10: String?,//Nullable
    val measure11: String?,//Nullable
    val measure12: String?,//Nullable
    val measure13: String?,//Nullable
    val measure14: String?,//Nullable
    val measure15: String?,//Nullable*/



    //val imgLink: String,//"https://www.thecocktaildb.com/drink/11415"

    val likedByMe: Boolean,
    //"strImageAttribution": null,
    //"strCreativeCommonsConfirmed": "Yes",
    //"dateModified": "2017-09-08 16:10:40"
)
