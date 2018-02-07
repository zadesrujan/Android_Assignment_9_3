package com.example.user.android_assignment_9_3;
//Package objects contain version information about the implementation and specification of a Java package.
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    //public is a method and fields can be accessed by the members of any class.
    //class is a collections of objects.
    //created MainActivity and extends with AppCompatActivity which is Parent class that implements the onintemclick listner.
    ListView listView;
    Adapter adapter;
    int index=0;
    //starting array index is 0
    //Taking string of name and number
    private final static String name[]={"Vidu","Sonu","Srujan","Sudha","Priyanka","Nagaraj","Uma"};
    //giving the names of the persons and keeping them in string
    private final static String number[]={"8937578901","7864531289","9676716797","9999767676","8712007456","9990938309","9812546754"};
    //giving the numbers of the persons and keeping them in string
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design

        listView=(ListView)findViewById(R.id.listView);
        // View IDs need not be unique throughout the tree, but it is good practice to ensure that they are at least unique within the
        //part of the tree you are searching of list view
        adapter = new com.example.user.android_assignment_9_3.Adapter(this, name, number) {
            public CharSequence[] getAutofillOptions() {
                return new CharSequence[0];
            }
        };
//creating adapter object for adding name and number
        //Sets the data behind this ListView.
        listView.setAdapter((ListAdapter) adapter);
        //Interface definition for a callback to be invoked when an item in this AdapterView has been clicked.
        listView.setOnItemClickListener(this);
        registerForContextMenu(listView);
        //Registers a context menu to be shown for the given view (multiple views can show the context menu).
    }



    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this, "Long press to Call /SMS", Toast.LENGTH_SHORT).show();
        index=i;
        //here index of the array is equal to position
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // creating context Menu
        //Android context menu appears when user press long click on the element. It is also known as floating menu.
        //Called when the context menu for this view is being built.
        menu.setHeaderTitle("Select the Action");
        // adding header in the menu
        menu.add(0, 1, 0, "Call");
        menu.add(0, 2, 1, "Send SMS");
        // adding call and send sms action in the menu
    }

    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public boolean onContextItemSelected(MenuItem item) {
        //This hook is called whenever an item in a context menu is selected.
        //Applying conditions for cal;l and sms
        try {
            //  call
            if(item.getItemId()==1 && item.getGroupId()==0){
                Intent i=new Intent();
                //here we are creating intent
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+number[index]));
                //intent is an abstract description of an operation to be performed
                //setting an action to dial the number and here the numbers are in the form of inderx that which are given in the array
                startActivity(i);
                //here the activity get started for call
            }
            // sms
            else if(item.getItemId()==2 && item.getGroupId()==0){
                Intent i=new Intent();
                //Creating  the intent to show number
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+ number[index])));
                //Starting the intent for msg
                startActivity(i);
            }
            else{
                return false;
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }
    @Override
    //we use override to tells the compiler that the following method overrides a method of its superclass.
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return super.onCreateOptionsMenu(menu);
        //Initialize the contents of the Activity's standard options menu. You should place your menu items in to menu.
        //Returns a MenuInflater with this context and returns the menu
    }
}

