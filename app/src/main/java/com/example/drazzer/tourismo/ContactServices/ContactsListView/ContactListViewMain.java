package com.example.drazzer.tourismo.ContactServices.ContactsListView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.drazzer.tourismo.R;

public class ContactListViewMain extends AppCompatActivity {

    private StringResource stringResource;
    private ContactListViewAdapter contactListViewAdapter;
    private ListView listView;

    private String[] busServicesname = {"hanif enterprise",
            "shyamoli paribahan",
            "unique",
            "starline",
            "TR travels",
            "eagle paribahan",
            "saudia paribahan",
            "S alam",
            "shohag paribahan",
            "greenline",
            "saintmartin",
            "baghdad",
            "desh travels"
    };

    private String[] getBusServicesNumber = {
            "01713402634",
            "01818209627",
            "01928721484",
            "01818632276",
            "01722384499",
            "01710166252",
            "01919654811",
            "01711272183",
            "01733052201",
            "01970060045",
            "01719639447",
            "0182736110",
            "01819108584"
    };

    private String hotelNames[] = {"Long beach",
            "Sea-gull",
            "The Cox Today",
            "Sea Palace",
            "Osman Paradice",
            "Sea Crown",
            "Sea Princess",
            "Bay View Guest House and restaurant",
            "Urmi Guest House",
            "Seint Martin resot",
            "Coral Reef",
            "R M Guest House",
            "Hotel Mishuk",
            "Marmaid Eco Resot",
            "Media International",
            "Hotel Kollol",
            "Hotel Sea World",
            "Prashad Paradice",
            "Ziya Guest In",
            "Diamond Palace",
            "Albatris Resot",
            "Ikra Beach Resot",
            "Sea Arafat Resot",
            "Hotel Sea Park",
            "Sea Heal Guest House",
            "Cox View Resort",
            "Sea Cox Resort",
            "Shams Plaza",
            "gelaxy resort",
            "houneymoon resort",
            "grand beach resort",
            "A R guest house",
            "regal plus",
            "shamim guest house",
            "sea king guest house",
            "Ziya guest house",
            "taher vaban",
            "sarmon guest house",
            "cox in",
            "kowality home",
            "haque guest in",
            "shohag guest house",
            "sainmartin resort",
            "sae land guest house",
            "sae bridge resort",
            "alam guest house",
            "nitol bay resort",
            "meher a gawchiya resort",
            "hotel merin plaza",
            "sae welcome resort",
            "sae sun resort",
            "beach holiday",
            "noor plaza",
            "shugandha guest house",
            "sea alif",
            "blue ocean",
            "nishan guest house",
            "lemich resort",
            "resort beach view",
            "hotel silver sign",
            "shonar gaw",
            "hotel palongki",
            "hotel panowa",
            "hotel gardan",
            "niribili",
            "sea queen",
            "hotel banu plaza",
            "alin park",
            "hotel marmaid",
            "hotel nishita",
            "hotel alhera",
            "hotel sea board",
            "hotel bilkis",
            "hotel ziya",
            "hotel merina",
            "hotel bolaka",
            "hotel mowshumi",
            "hotel M S guest care",
            "hotel taj sheba",
            "hotel noor a sokina",
            "al hossain",
            "asia",
            "al nizam",
            "bay-empier",
            "hotel royal",
            "al amin",
            "saikat",
            "zilani",
            "renesa",
            "jhaw tola",
            "hotel sowdiya",
            "hotel arman",
            "al wazed",
            "cox wa",
            "rajmoni",
            "S K international",
            "cox ocean resort",
            "ramjan cotage",
            "joynal resort",
            "shomudro nibash",
            "hill cross",
            "sea home",
            "M A guest gill",
            "rajion cotage",
            "beach garden",
            "beach city resort",
            "johir ahmed resort",
            "dream guest in",
            "gee - green resort",
            "sajjad cotage",
            "shopno bilash",
            "haque garden",
            "shakil guest house",
            "light house",
            "shomudro kanta guest house",
            "arman cotage",
            "dar al ehsan guest house",
            "gee garden",
            "sea dain resort",
            "md. Ali guest house",
            "dhakar bari",
            "hamid resort",
            "bela vumi guest house",
            "hill side resort",
            "diamond angle",
            "M ali guest house",
            "fahim cotage",
            "beach noor cotage",
            "beach park cotage",
            "morshed resort",
            "rongdhonu resort",
            "sea sand resort",
            "elham cotage",
            "rongdhonu guest resort",
            "dhaka cotage",
            "shamshed resort",
            "blue water cotage",
            "liton moon cotage",
            "beach noor cotage",
            "al hossain cotage",
            "hill down guest house",
            "emran guest house",
            "kolim resort",
            "fahim cotage",
            "ahammadia resort",
            "sea choise guest house",
            "ocean city resort",
            "dhaka cotage, shoron abashik elaka",
            "sea park cotage",
            "hotel sky view",
            "hotel knaf international",
            "hotel shamrat",
            "hotel dip plaza",
            "hotel hill top",
            "milky resort",
            "hotel green garden",
            "hotel knaf qui",
            "hotel prashad paradice",
            "white house sea",
            "hotel rose marry",
            "blue merin",
            "hotel sri blue",
            "hotel sen shor",
            "hotel shopno bilash",
            "trip haven",
            "ruposhi bangla",
            "blue sea star",
            "coral view",
            "sae star",
            "hotel sea in",
            "sea gold",
            "marmaid resort",
            "moynamoti resort",
            "green land resort",
            "hotel obokash",
            "hotel C T V resort",
            "labiba bilash",
            "hotel shomudro bilash",
            "panna resort",
            "dream night resort",
            "gimana peri resort",
            "hotel coral view",
            "shomudro kutir resort",
            "nill digonto resort",
            "shonar para resort",
            "payvel stone"
    };


    String[] hotelNumbers = {
            "017303389079",
            "01766666531",
            "01755598449",
            "017146522278",
            "034152370",
            "034164474",
            "0347164378",
            "01858532333",
            "01819082772",
            "01819809057",
            "0175463177",
            "01814725546",
            "01715946471",
            "01841416464",
            "034162881",
            "034164748",
            "034164278",
            "01827715655",
            "034164701",
            "034163642",
            "034164684",
            "01819608172",
            "01715077126",
            "034151078",
            "034163088",
            "01822889929",
            "01616200500",
            "01919808494",
            "034151155",
            "01919808494",
            "01720355991",
            "01814725546",
            "01676565599",
            "01815810661",
            "0181858088",
            "01712087870",
            "01819033861",
            "034164740",
            "01733570213",
            "0347164882",
            "01818166348",
            "01818066980",
            "034162462",
            "0181661417",
            "034163096",
            "0199209276",
            "034164278",
            "01819567351",
            "01818567351",
            "01824465934",
            "034151045",
            "0155360053",
            "01735430616",
            "0341624667",
            "01715755112",
            "034163207",
            "034162701",
            "01817205015",
            "034151281",
            "0171314778",
            "034164288",
            "01711172035",
            "01711946417",
            "01819063476",
            "034163202",
            "034163789",
            "034164368",
            "01711114454",
            "0341639447",
            "034164362",
            "01818141236",
            "01818141237",
            "034163982",
            "034163253",
            "034163611",
            "034164497",
            "034164486",
            "034163930",
            "034164360",
            "034163945",
            "034164003",
            "034162011",
            "034162080",
            "034163052",
            "0347164410",
            "034164631",
            "034164490",
            "034163520",
            "034164712",
            "034163476",
            "034163352",
            "034164409",
            "034163899",
            "034163566",
            "034163114",
            "034163830",
            "01815914481",
            "01815152515",
            "01831900183",
            "01830738004",
            "01830738004",
            "01819431199",
            "01815347290",
            "01815856686",
            "01816444674",
            "01819534900",
            "03413641",
            "01822536915",
            "01822536915",
            "01814770482",
            "01947148508",
            "01828104966",
            "01814181179",
            "01831838277",
            "01815438819",
            "01814770482",
            "01713047646",
            "018193690710",
            "01713448311",
            "01829666643",
            "01840180444",
            "01815045991",
            "01819367124",
            "01812611607",
            "01199738434",
            "03416603",
            "034151921",
            "01813250880",
            "034151808",
            "01913194428",
            "01762495052",
            "01819172790",
            "01830127949",
            "01712083824",
            "01830053576",
            "01824546964",
            "0183342650",
            "01914461486",
            "01832247811",
            "01817799843",
            "01838371552",
            "01820120488",
            "01818239754",
            "01819082641",
            "01812211749",
            "01811918596",
            "01819352122",
            "01675594168",
            "0193617599",
            "01819097910",
            "01820538865",
            "01716659389",
            "01818050052",
            "01717311117",
            "01852469616",
            "01840003388",
            "01823965142",
            "01975707070",
            "01728035474",
            "01743695196",
            "01713399250",
            "01894534201",
            "01757144244",
            "01818510646",
            "01728035474",
            "01817225242",
            "01830071091",
            "01832979541",
            "01817057315",
            "01735581251",
            "01839224876",
            "01819077014",
            "01822537650",
            "0187223794",
            "01718561177",
            "01813267922",
            "01727368589",
            "01816172615",
            "01811179961",
            "01819018037",
            "01819018037",
            "01816088505",
            "01816503129",
            "01720051004",
            "01811277589",
            "01713041300"

    };


    String[] airlineName = {"Biman Bangladesh Airlines",
            "US-Bangla Airlines",
            "Novoair",
            "Regent Airways",
            "United Airways",
    };

    String[] airlineNumber = {"+88028901306", "+8801777777806", "+8809666722224", "+8801730358820", "+8801713486664"};

    String[] emergencyServicesName = {"hot line 1",
            "hot line 2",
            "hot line 3",
            "shohokari police super",
            "otirikto police super",
            "sea safe life guard",
            "robi life guard",
            "yasir life guard",
    };

    String[] emergencyServicesNumber = {"01769690740",
            "01769690734",
            "01769690732",
            "01769690734",
            "01769690732",
            "01676840804",
            "01818466584",
            "01711102829",
    };

    String[] helpLineName = {
            "executive magistrate, parjanta",
            "tourist police 1",
            "tourist police 2",
    };
    String[] helpLineNumber = {
            "01733373127",
            "01769690732",
            "01799900066",

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list_view_main);

        listView = findViewById(R.id.contactList);
        Intent mintent = getIntent();
        int message = mintent.getIntExtra("selection", 0);


        if (message == 0) {
            stringResource = new StringResource(airlineName, airlineNumber);
        } else if (message == 1) {
            stringResource = new StringResource(emergencyServicesName, emergencyServicesNumber);
        } else if (message == 2) {
            stringResource = new StringResource(helpLineName, helpLineNumber);
        } else if (message == 3) {
            stringResource = new StringResource(busServicesname, getBusServicesNumber);
        } else if (message == 4) {
            stringResource = new StringResource(hotelNames, hotelNumbers);
        }


        contactListViewAdapter = new ContactListViewAdapter(stringResource, getApplicationContext());


        listView.setAdapter(contactListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(stringResource.getIndividualNumber(i).equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Contact not found!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+stringResource.getIndividualNumber(i)));
                    startActivity(intent);
                }
            }
        });





    }
}









class StringResource{
    String [] name,number;

    public StringResource() {
    }

    public StringResource(String[] name, String[] number) {
        this.name = name;
        this.number = number;
    }

    public String[] getName() {
        return name;
    }

    public String[] getNumber() {
        return number;
    }

    public String getIndividualNumber(int position) {
        return number[position];
    }

    public String getIndividualName(int position) {
        return name[position];
    }


}
