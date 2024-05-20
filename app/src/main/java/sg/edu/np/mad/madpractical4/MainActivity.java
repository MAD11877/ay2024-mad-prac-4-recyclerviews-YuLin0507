package sg.edu.np.mad.madpractical4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve the random number from the intent extras
        int randomNumber = getIntent().getIntExtra("RANDOM_NUMBER", 0);

        // Initialise a new user object
        User user = new User("MAD", "MAD developer", 1, false);

        // Gets the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.textView4);
        TextView tvDescription = findViewById(R.id.textView3);
        Button btnFollow = findViewById(R.id.button2);
        Button btnMessage = findViewById(R.id.button);

        // Set the text view with the user's name, description, and default button message
        tvName.setText(user.name + " " + randomNumber);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        // Set OnClickListener for the "Follow" button
        btnFollow.setOnClickListener(view -> {
            String message;
            if (user.followed) {
                btnFollow.setText("Unfollow");
                message = "Followed";
            } else {
                btnFollow.setText("Follow");
                message = "Unfollowed";
            }
            user.followed = !user.followed;

            // Display the Toast message
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

            // Log a message to verify if the OnClickListener is triggered
            Log.d("MainActivity", "Follow button clicked. Message: " + message);
        });

    }
}