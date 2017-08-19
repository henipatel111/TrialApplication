package com.example.heni.MyApp.viewholders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.models.Lesson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by heni on 20/7/17.
 */

public class LessonTileViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "LessonTileHolder";
    RelativeLayout relativeLessonCard;
    android.support.v7.widget.CardView cardViewLesson;
    LinearLayout lessonTileHolder;
    RelativeLayout relativeCoverHolder;
    ImageView imageViewCoverImage;
    LinearLayout linearDetails;
    TextView textViewLessonTitle;
    TextView textViewAuthor;
    RelativeLayout relativeBottom;
    TextView textViewPrice;
    RelativeLayout relativeRating;
    TextView textViewRating;
    ImageView ratingStar1;


    Animation fadeIn;

    public LessonTileViewHolder(View itemView) {
        super(itemView);
        bindViews(itemView);
    }

    public static String getTAG() {
        return TAG;
    }


    private void bindViews(View rootView) {
        relativeLessonCard = (RelativeLayout) rootView.findViewById(R.id.relative_lesson_card);
        cardViewLesson = (android.support.v7.widget.CardView) rootView.findViewById(R.id.cardView_lesson);
        lessonTileHolder = (LinearLayout) rootView.findViewById(R.id.lessonTile_holder);
        relativeCoverHolder = (RelativeLayout) rootView.findViewById(R.id.relative_coverHolder);
        imageViewCoverImage = (ImageView) rootView.findViewById(R.id.imageView_coverImage);
        linearDetails = (LinearLayout) rootView.findViewById(R.id.linear_details);
        textViewLessonTitle = (TextView) rootView.findViewById(R.id.textView_lessonTitle);
        textViewAuthor = (TextView) rootView.findViewById(R.id.textView_author);
        relativeBottom = (RelativeLayout) rootView.findViewById(R.id.relative_bottom);
        textViewPrice = (TextView) rootView.findViewById(R.id.textView_price);
        relativeRating = (RelativeLayout) rootView.findViewById(R.id.relative_rating);
        textViewRating = (TextView) rootView.findViewById(R.id.textView_rating);
        ratingStar1 = (ImageView) rootView.findViewById(R.id.ratingStar1);
    }

    public void attachLesson(Context context, Lesson lesson) {
        //sets names
        getTextViewLessonTitle().setText(lesson.getLessonTitle());
        fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in_primarychooser);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imageViewCoverImage.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        getTextViewAuthor().setText("by " + lesson.getPublisherName());


        if (lesson.isPaid()) {
            textViewPrice.setTextColor(context.getResources().getColor(R.color.google_blue_200));
        } else {
            textViewPrice.setTextColor(context.getResources().getColor(R.color.google_blue_400));
        }
        textViewPrice.setText(lesson.getPrice());

        if (lesson.getRating() > 0) {
            relativeRating.setVisibility(View.VISIBLE);
        } else {
            relativeRating.setVisibility(View.INVISIBLE);
        }

        applyLessonThemeToSquareTile(context, lesson);
       // addClickListenerToSquareTile(context, lesson);
    }

    private void applyLessonThemeToSquareTile(Context context, Lesson lesson) {
        //to avoid styling in recycled holder.
        if (getTextViewLessonTitle().getText().equals(lesson.getLessonTitle())) {
           /* getImageViewCoverImage().setImageBitmap(lesson.getCoverImageBitmap());
            getRelativeCoverHolder().setBackgroundColor(lesson.getCoverPalette().getMutedSwatch().getRgb());
            if (lesson.getCoverImageBitmap() == null) {
                downLoadAndApplyTheme(context, lesson);
            }*/
        }
    }

    /**
     * downloads the cover image and fill the theme back in @param recyclerTile.
     * Only if already not loaded.
     *
     * @param context
     */
    private void downLoadAndApplyTheme(Context context, Lesson lesson) {
        if (lesson.coverDownloadState == Lesson.COVER_NOT_INITIATED || lesson.coverDownloadState == Lesson.COVER_STATE_FAILED) { //when first time
            Log.d("LessonBitmap", "point 1 " + lesson.getLessonTitle());
            if (lesson.getCoverImageThumbUrl() == null || lesson.getCoverImageThumbUrl().length() == 0) {
                Log.d("LessonBitmap", "point 2 " + lesson.getLessonTitle());
              //  lesson.setCoverPalette(LearnaptPalette.getGeneralPaletteForID(lesson.getLessonId()));
                lesson.coverDownloadState = Lesson.COVER_STATE_LOADED;
            } else {
                try {
                    PicassoSquareTileTarget strongTarget;
                    Log.d("LessonBitmap", "point 3 " + lesson.getLessonTitle());
                    strongTarget = new PicassoSquareTileTarget(context, lesson);
                    Log.d("Started fetching:", lesson.getLessonTitle());
                    //loads coverImage to back of Home lesson
                    imageViewCoverImage.setTag(strongTarget);
                    Picasso.with(context)
                            .load(lesson.getCoverImageThumbUrl())
                            .into(strongTarget);

                } catch (Exception ex) {
                    Log.d("LessonBitmap", "point 4 " + lesson.getLessonTitle());
                    lesson.coverDownloadState = Lesson.COVER_STATE_FAILED;
                    ex.printStackTrace();
                } finally {
                    Log.d("LessonBitmap", "point 5 " + lesson.getLessonTitle());
                }
            }
        }
    }

   /* public void addClickListenerToSquareTile(final Context context, final Lesson lesson) {
        final Lesson currentLesson = lesson;
        getLessonTileHolder().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LessonHomeActivity.openLesson(context, currentLesson);
            }
        });
    }*/


    public LinearLayout getLessonTileHolder() {
        return lessonTileHolder;
    }

    public RelativeLayout getRelativeCoverHolder() {
        return relativeCoverHolder;
    }

    public ImageView getImageViewCoverImage() {
        return imageViewCoverImage;
    }

    public TextView getTextViewLessonTitle() {
        return textViewLessonTitle;
    }

    public TextView getTextViewAuthor() {
        return textViewAuthor;
    }

    public RelativeLayout getRelativeBottom() {
        return relativeBottom;
    }

    public TextView getTextViewPrice() {
        return textViewPrice;
    }

    public RelativeLayout getRelativeRating() {
        return relativeRating;
    }

    public ImageView getRatingStar1() {
        return ratingStar1;
    }

    private class PicassoSquareTileTarget implements Target {
        Context context;
        Lesson lesson;

        public PicassoSquareTileTarget(Context context, Lesson lesson) {
            this.context = context;
            this.lesson = lesson;
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            lesson.coverDownloadState = Lesson.COVER_STATE_LOADED;
            Log.d("LessonBitmap", "onLoaded for " + lesson.getLessonTitle());
            // lesson.setCoverImageBitmap(bitmap);
            //lesson.setCoverPalette(Palette.generate(bitmap, 16));
            if (getTextViewLessonTitle().getText().equals(lesson.getLessonTitle())) {
                imageViewCoverImage.setVisibility(View.INVISIBLE);
                imageViewCoverImage.setImageBitmap(bitmap);
                imageViewCoverImage.startAnimation(fadeIn);
            }
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            Log.d("LessonBitmap", "Failed for " + lesson.getLessonTitle());
            lesson.coverDownloadState = Lesson.COVER_STATE_FAILED;
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            Log.d("LessonBitmap", "onPrepare for " + lesson.getLessonTitle());
            lesson.coverDownloadState = Lesson.COVER_STATE_IN_PROGRESS;
        }
    }
}
