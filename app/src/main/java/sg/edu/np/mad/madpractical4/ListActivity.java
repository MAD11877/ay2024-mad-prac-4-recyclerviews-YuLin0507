package sg.edu.np.mad.madpractical4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<User> myUserList = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            int name = new Random().nextInt(99999999);
            int description = new Random().nextInt(99999999);
            boolean followed = new Random().nextBoolean();

            User user = new User("John Doe","MAD",1, false);
            user.setName("Name"+String.valueOf(name));
            user.setDescription("Description"+String.valueOf(description));
            user.setFollowed(followed);
            boolean add = myUserList.add(user);

        }

        ImageView imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");

        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // Generate a random integer
                int randomNumber = generateRandomNumber();

                // Launch MainActivity and pass the random number
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                intent.putExtra("RANDOM_NUMBER", randomNumber);
                startActivity(intent);

                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100000);
    }

    // create a list of 20 random users

}
