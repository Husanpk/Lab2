package com.cst2335.lab2;

public class Message {

    public static int message;
    int Image;
    int id ;


  String Des;
  public Message(){

  }

    public Message(int id ,int image , String des) {
        Image = image;
id = id ;
        Des = des;
    }
    public Message(int image , String des) {
        Image = image;

        Des = des;
    }
public Message(String des){
      Des = des;
}

    public Message(String string, boolean b) {
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }



    public String getDes() {
        return Des;
    }

    public void  setDes(String Des) {
        this.Des = Des;
    }



}
