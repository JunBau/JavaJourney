package com.JunBau;

public class Button {

    private String Title;
    private OnClickListener onClickLister;

    Button(String title) {
        this.Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setOnClickLister(OnClickListener onClickListener) {
        this.onClickLister = onClickListener;
    }

    public void onClick() {
        this.onClickLister.onClick(this.Title);
    }

    public interface OnClickListener {
        public void onClick(String title);
    }
}
