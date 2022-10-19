# XMaterial Compose Country Code Picker

Jetpack Compose Material Country Code Picker

<a href="https://www.linkedin.com/mwlite/in/tule-simon-67a202157">Chat me up on Linkedln</a>

## Latest Version
The latest version is <a href="https://github.com/TuleSimon/xMaterialccp/releases/tag/v1.04">V1.04</a>

# CREDIT
This project was forked from <a href="https://github.com/togisoft/jetpack_compose_country_code_picker">togisoft</a>,
His Github repo and efforts are what laid the ground work for me to improve on it and create a more customizable version of his library,


<h1>WELCOME</h1>

If you are looking for a highly customizable and Material Country Phone Code Picker for Jetpack Compose you can use the package.


* Country numbers hints
* Phone number visualTransformation (Automatic number formatting)
* Automatic country recognition (detection by sim card if sim card is inserted)
* With TextField
* Can Customize
* Added language translations
* Added clear text button
* Dialog changed and customized

Languages:

* Turkish
* English
* Italian
* Arabic
* Russian

New features will be added as time goes by and updates will be made. This project is open source without any profit motive.

For language support, you can send me a message.
<a href="https://www.linkedin.com/mwlite/in/tule-simon-67a202157">Chat me up on Linkedln</a>

<h3>Screenshots</h3>
<div class="row">
  <img src="screenshots/Screenshot_dialog.jpg" width="300"> 
  <img src="screenshots/Screenshot_dialog2.jpg" width="300"> 
  <img src="screenshots/Screenshot_error.jpg" width="300"> 
  <img src="screenshots/Screenshot_roundedccp.jpg" width="300">
 </div>


**** Specifications ****

<h3> Material Country Code Picker </h3>

```kotlin
@Composable
fun MaterialCountryCodePicker(
    text: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    /**
     * If the country code should be shown or just show flag
     *
     */
    showCountryCode: Boolean = true,
    /**
     * If the country flag should be shown or just show code
     *
     */
    showCountryFlag: Boolean = true,
    /**
     * The default country to be showed when the ccp is first initialized without any selection
     *
     */
    defaultCountry: CountryData,
    pickedCountry: (CountryData) -> Unit,
    focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
    unfocusedBorderColor: Color = MaterialTheme.colorScheme.onSecondary,
    /**
     * The color to be used for the cursor on the textfield
     *
     */
    cursorColor: Color = MaterialTheme.colorScheme.primary,
    /**
     * The background color of the topappbar
     *
     */
    dialogAppBarColor: Color = MaterialTheme.colorScheme.primary,
    error: Boolean=false,
    /**
     * if the error text should be shown
     *
     */
    showErrorText: Boolean=true,
    rowPadding: PaddingValues = PaddingValues(vertical = 10.dp, horizontal = 10.dp),
    /**
     * The color to be used as surface background for the country lazy column
     *
     */
    surfaceColor:Color = MaterialTheme.colorScheme.surface,
    /**
     * The color of the country text in the lazy column
     *
     */
    countryTextColor:Color = MaterialTheme.colorScheme.onBackground,
    /**
     * The color to be used for a row in the lazy column
     *
     */
    countryItemBgColor:Color = Color.Unspecified,
    /**
     * The shape to be used for a row in the lazy column
     *
     */
    countryItemBgShape:RoundedCornerShape = RoundedCornerShape(0.dp),
    countryCodeTextColor:Color = MaterialTheme.colorScheme.onBackground,
    /**
     * The color to be used for the numbers on the textfield
     *
     */
    numberTextColor:Color = MaterialTheme.colorScheme.onBackground,
    searchFieldPlaceHolderTextColor:Color = MaterialTheme.colorScheme.onBackground,
    searchFieldTextColor:Color = MaterialTheme.colorScheme.onBackground,
    searchFieldBackgroundColor:Color = MaterialTheme.colorScheme.background.copy(0.7f),
    searchFieldShapeCornerRadiusInPercentage:Int = 30,
    textFieldShapeCornerRadiusInPercentage:Int = 30,
    errorTextStyle:TextStyle = MaterialTheme.typography.bodyMedium,
    /**
     * The navigation icon tint on the top app bar
     *
     */
    dialogNavIconColor: Color = MaterialTheme.colorScheme.onBackground,
    /**
     * The text style to be used for the top app bar title
     *
     */
    appbartitleStyle :TextStyle = MaterialTheme.typography.titleLarge,
)

```  



<h3>  Field Usage </h3>

```kotlin
@Composable
fun SelectCountryWithCountryCode() {
    val context = LocalContext.current
    var phoneCode by remember { mutableStateOf(getDefaultPhoneCode(context)) }
    val phoneNumber = rememberSaveable { mutableStateOf("") }
    var defaultLang by rememberSaveable { mutableStateOf(getDefaultLangCode(context)) }
    var isValidPhone by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        MaterialCountryCodePicker(
            pickedCountry = {
                phoneCode = it.countryPhoneCode
                defaultLang = it.countryCode
            },
            defaultCountry = getLibCountries().single { it.countryCode == defaultLang },
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.primary,
            dialogAppBarColor = Color.White,
            error = !isValidPhone,
            text = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            surfaceColor = MaterialTheme.colorScheme.surface,
            searchFieldPlaceHolderTextColor = Color.Gray,
            searchFieldBackgroundColor = MaterialTheme.colorScheme.secondaryContainer,
            textFieldShapeCornerRadiusInPercentage = 40,
            searchFieldTextColor = MaterialTheme.colorScheme.onSurface,
            searchFieldShapeCornerRadiusInPercentage = 40,
            countryTextColor = MaterialTheme.colorScheme.onSurface,
            countryCodeTextColor = MaterialTheme.colorScheme.onBackground,
            appbartitleStyle = MaterialTheme.typography.titleLarge,
            countryItemBgShape = RoundedCornerShape(20.dp),
            showCountryFlag = true,
            showCountryCode = true,
        )

        val fullPhoneNumber = "$phoneCode${phoneNumber.value}"
        val checkPhoneNumber = checkPhoneNumber(
            phone = phoneNumber.value,
            fullPhoneNumber = fullPhoneNumber,
            countryCode = defaultLang
        )
        OutlinedButton(
            onClick = {
                isValidPhone = checkPhoneNumber
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(
                    50.dp
                )
        ) {
            Text(text = "Phone Verify")
        }
    }
}


```  

<h3><- ********* Extras ********* -></h3>

* focusedBorderColor = TextField Border Color
* unfocusedBorderColor = TextField Unfocused Border Color
* cursorColor = TextField Cursor Color
* showCountryCode = if to show or hide country code
* showCountryFlag = if to show or hide country flag
* appbartitleStyle = the style to use for the app bar in the dialog
* countryCodeTextColor = the text color for the country code
* countryTextColor = the text color for the country in the lazy column
* searchFieldShapeCornerRadiusInPercentage = the corner radius for the search field shape
* searchFieldTextColor =  the search field text color when typing
* textFieldShapeCornerRadiusInPercentage = the phone number text field corner radius in percentage
* searchFieldBackgroundColor = the search field background color
* searchFieldPlaceHolderTextColor = the search field placeholder color
* dialogAppBarColor = the color of the app bar
* dialogNavIconColor =  the color of the app bar nav icon
* countryItemBgColor =  the country item row in the lazy column background color
* countryItemBgShape = the country item row in the lazy column shape
* countryItemVerticalPaddding = the space between two country items


<h3> How to add in your project </h3>

In the build.gradle add maven central repository

```groovy
    repositories {
    maven { url 'https://jitpack.io' }
}

```

Step 2. Add the dependency

```
  dependencies {
	  implementation 'com.github.TuleSimon:xMaterialccp:$latest_version'
	}  
```    


<h3> Addition of new Features or Bug Request </h3>

Feel free to contact me for any feature request or file an issue if a bug is encountered 