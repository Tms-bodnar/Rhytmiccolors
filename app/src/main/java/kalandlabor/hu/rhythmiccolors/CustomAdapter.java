package kalandlabor.hu.rhythmiccolors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by user on 2017.04.25..
 */
public class CustomAdapter extends BaseAdapter{
    Context context;
    int[] flippedImages;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, int[]flippedImages){
        this.context = applicationContext;
        this.flippedImages = flippedImages;
        inflater = LayoutInflater.from(applicationContext);

    }

    @Override
    public int getCount() {
        return flippedImages.length;
    }

    @Override
    public Object getItem(int position) {
        if(flippedImages.length<position && position<0)return null;
        else return flippedImages[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_list, null);
        ImageView flippImageView = (ImageView) convertView.findViewById(R.id.flipped_image);
        flippImageView.setImageResource(flippedImages[position]);
        return convertView;
    }
}
