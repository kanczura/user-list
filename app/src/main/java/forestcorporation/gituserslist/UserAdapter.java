package forestcorporation.gituserslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Magda on 2018-03-22.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersViewHolder> {

    private static final String TAG = UserAdapter.class.getSimpleName();
    private List<User> list;
    private OnItemClickListener listener;

    public UserAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void updateAdapter(List<User> usersList) {
        list = usersList;
        notifyDataSetChanged();
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutForList = R.layout.row;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutForList, viewGroup, Boolean.parseBoolean(null));
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {

        TextView userTextView;
        ImageView avatarImageView;

        public UsersViewHolder(View itemView) {
            super(itemView);

            userTextView = (TextView) itemView.findViewById(R.id.tv_users);
            avatarImageView = (ImageView) itemView.findViewById(R.id.iv_avatar);
            itemView.setClickable(true);
        }

        public void bind(final User user, final OnItemClickListener listener) {
            userTextView.setText(user.getLogin());
            Glide.clear(itemView);
            Glide.with(itemView.getContext()).load(user.getAvatar_url()).override(200,200).into(avatarImageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(user);
                }
            });
        }
    }
}
