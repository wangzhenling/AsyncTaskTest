package com.example.asynctasktest;

import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownTask extends AsyncTask<Integer,Integer,String> {
	
    private TextView tv;
    private ProgressBar pb;
    
    public DownTask(TextView tv,ProgressBar pb){
    	this.tv=tv;
    	this.pb=pb;
    }
    
    public DownTask(){
    	
    }

	@Override
	protected String doInBackground(Integer... params) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<=100;i++){
			publishProgress(i);
			try {
				Thread.sleep(params[0]);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "下载完毕";
	}
	
	protected void onPreExecute(){
		super.onPreExecute();
	}
	
	protected void onPostExecute(String result){
		
		tv.setText(result);
		tv.setTextColor(Color.RED);
		tv.setTextSize(20);
		pb.setVisibility(View.INVISIBLE);
		super.onPostExecute(result);
	}
	
	protected void onProgressUpdate(Integer...params){
		
		tv.setText("当前完成任务的"+params[0]+"%");
		pb.setProgress(params[0]);
		tv.setVisibility(View.VISIBLE);
		pb.setVisibility(View.VISIBLE);
		super.onProgressUpdate(params);
		
	}

}
