package com.gordonlu.linearprogressbar;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.widget.ProgressBar;
import android.graphics.PorterDuff;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.R.attr;

import android.os.Build;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;

import android.view.View;
import android.widget.FrameLayout;

@DesignerComponent(
        version = 1,
        description = "A non-visible extension that indicates the progress of an operation using an animated linear bar.",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "https://docs.google.com/drawings/d/e/2PACX-1vQCI87PHLBF0jb8QWyYmIRQSjjNW3EFXf-qpsWCvBYkUQ9vEgPAB8SpxcMpblxNpbIYrjCjLrRLIU2c/pub?w=16&h=16")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class LinearProgressbar extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;

    public LinearProgressbar(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleEvent(description = "This event is fired when the progress of a linear progress bar has changed." + 
    " The progress parameter returns the current progress value. If you have enabled Inderterminate for this progress bar, 'progress' will be 0.")
    public final void ProgressChanged(AndroidViewComponent container, int id, int progress) {
        EventDispatcher.dispatchEvent(this, "ProgressChanged", container, id, progress);
    }

    @SimpleFunction(description = "Changes the indeterminate color of the progress bar.")
    public void SetIndeterminateColor(AndroidViewComponent container, int id, int color) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        progress.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    @SimpleFunction(description = "Changes the progress color of the progress bar.")
    public void SetProgressColor(AndroidViewComponent container, int id, int color) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        progress.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    @SimpleFunction(description = "Sets the current progress to the specified value. Does not do anything if the progress bar is in indeterminate mode.")
    public final void SetProgress(final AndroidViewComponent container, final int id, int progress) {
        View layout = container.getView();
        ProgressBar prog = layout.findViewById(id);
        if (Build.VERSION.SDK_INT >= 24) {
            prog.setProgress(progress, true);
        } else {
            prog.setProgress(progress);
        }
        ProgressChanged(container, id, prog.getProgress());
    }

    @SimpleFunction(description = "Get the progress bar's current level of progress. Return 0 when the progress bar is in indeterminate mode.")
    public final int GetProgress(final AndroidViewComponent container, final int id) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        int test = progress.getProgress();
        return test;
    }

    @SimpleFunction(description = "Change the indeterminate mode for this progress bar. In indeterminate mode, the progress is ignored and the progress bar shows an infinite animation instead.")
    public void SetIndeterminate(AndroidViewComponent container, final int id, boolean indeterminate) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        progress.setIndeterminate(indeterminate);
    }

    @SimpleFunction(description = "Creates a linear progress bar in the given container.")
    public void CreateLinearProgressbar(AndroidViewComponent container, int id, int color, boolean indeterminate) {
        View layout = container.getView();
        FrameLayout frame = (FrameLayout) layout;
        ProgressBar progressBar = new ProgressBar(activity, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setId(id);
        frame.addView(progressBar);
        if (indeterminate) {
            progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        } else {
            progressBar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        progressBar.setIndeterminate(indeterminate);
    }

    @SimpleFunction(description = "Increases the progress bar's progress by the specified amount.")
    public void IncrementProgressBy(AndroidViewComponent container, int id, int value) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        progress.incrementProgressBy(value);
    }

    @SimpleFunction(description = "Sets the upper range of the progress bar.")
    public void SetMaximum(AndroidViewComponent container, int id, int max) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        progress.setMax(max);
    }

    @SimpleFunction(description = "Returns the upper range of the progress bar.")
    public int GetMaximum(AndroidViewComponent container, int id) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        return progress.getMax();
    }

    @RequiresApi(api = 26)
    @SimpleFunction(description = "Returns the lower range of the progress bar. Only works in devices larger than API 25.")
    public void SetMinimum(AndroidViewComponent container, int id, int min) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        progress.setMin(min);
    }

    @RequiresApi(api = 26)
    @SimpleFunction(description = "Returns the upper range of the progress bar. Only works in devices larger than API 25.")
    public int GetMinimum(AndroidViewComponent container, int id) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        return progress.getMin();
    }

    // added in version 2

    @SimpleFunction(description = "Checks whether the progress bar is indeterminate or not.")
    public boolean IsIndeterminate(AndroidViewComponent container, int id) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        return progress.isIndeterminate();
    }

    @SimpleFunction(description = "Creates a usable ID that you can use to create a new progress bar." + 
    " Each progress bars in every screen should have a unique ID. You should save this in a global variable for later use and to avoid conflicts.")
    public int CreateUsableId(AndroidViewComponent container) {
        View layout = container.getView();
        return layout.generateViewId();
    }

    @SimpleFunction(description = "Sets the padding for the progress bar.")
    public void SetPadding(AndroidViewComponent container, int id, int left, int top, int right, int bottom) {
        View layout = container.getView();
        ProgressBar progress = layout.findViewById(id);
        progress.setPadding(left, top, right, bottom);
    }
}
