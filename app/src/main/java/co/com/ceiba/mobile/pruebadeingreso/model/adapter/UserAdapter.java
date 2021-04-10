package co.com.ceiba.mobile.pruebadeingreso.model.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import co.com.ceiba.mobile.pruebadeingreso.R;
import co.com.ceiba.mobile.pruebadeingreso.model.user.User;
import co.com.ceiba.mobile.pruebadeingreso.view.PostActivityView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> usersList;
    private LayoutInflater userInflater;

    public UserAdapter(List<User> listUsers, Context context) {
        this.usersList = listUsers;
        this.userInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = userInflater.inflate(R.layout.user_list_item, parent, false);
        return new UserAdapter.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        holder.bindData(usersList.get(position));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userPhone;
        TextView userEmail;
        Button btnViewUserPosts;
        User user;

        public UserViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.name);
            userPhone = itemView.findViewById(R.id.phone);
            userEmail = itemView.findViewById(R.id.email);
            btnViewUserPosts = itemView.findViewById(R.id.btn_view_post);

            btnViewUserPosts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, PostActivityView.class);
                    intent.putExtra("User", (Serializable) user);
                    context.startActivity(intent);
                }
            });

        }

        void bindData(final User user) {
            this.user = user;
            userName.setText(user.getUserName());
            userPhone.setText(user.getUserPhone());
            userEmail.setText(user.getUserEmail());
        }
    }
}
