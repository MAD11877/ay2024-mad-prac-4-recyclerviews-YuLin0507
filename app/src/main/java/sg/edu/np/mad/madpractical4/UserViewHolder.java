package sg.edu.np.mad.madpractical4;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTextView, descriptionTextView;
    public ImageView smallImageView, largeImageView;
    public Button followButton;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        smallImageView = itemView.findViewById(R.id.smallImage);
        largeImageView = itemView.findViewById(R.id.largeImage);
        followButton = itemView.findViewById(R.id.followButton);
    }
}



