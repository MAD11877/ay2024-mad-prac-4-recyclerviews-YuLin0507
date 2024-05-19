package sg.edu.np.mad.madpractical4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private List<User> userList;
    private Context context;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameTextView.setText(user.getName());
        holder.descriptionTextView.setText(user.getDescription());
        holder.smallImageView.setImageResource(R.mipmap.ic_launcher_round);
        holder.followButton.setText(user.isFollowed() ? "Unfollow" : "Follow");

        // Check if the last digit of the user's name is 7
        if (user.getName().endsWith("7")) {
            holder.largeImageView.setVisibility(View.VISIBLE);
        } else {
            holder.largeImageView.setVisibility(View.GONE);
        }

        holder.followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setFollowed(!user.isFollowed());
                holder.followButton.setText(user.isFollowed() ? "Unfollow" : "Follow");
                String message = user.isFollowed() ? "Followed" : "Unfollowed";
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });

        holder.smallImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(user.getName());
            }
        });
    }

    private void showAlertDialog(String userName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Profile");
        builder.setMessage("Name: " + userName);

        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("USER_NAME", userName);
                context.startActivity(intent);
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}


