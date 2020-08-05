package com.example.myapplication.amazonS3;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transfermanager.Upload;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.example.myapplication.LoginResponse;
import com.example.myapplication.SharedPrefManager;
import com.example.myapplication.User;
import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.FitbitSummary;
import com.fitbitsample.fitbitdata.FitbitUser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class amazonS3main extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void main(Context context) throws Exception {

        final String bucketName = "mobiledevt";
        final String keyName = "fitbitdata.csv";
        //final String accessKey = "AKIAY25P2SXYFRBZZYG7";
        // final String secretAccessKey = "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";
        //final String filepath = "C:\\Users\\sbhad\\Documents\\SD_Project\\senior-design-codebase\\Code\\app\\src\\main\\java\\com\\example\\myapplication\\amazonS3\\sample.txt";
        //final String filepath = "C:\\Users\\sbhad\\Documents\\senior-design-codebase\\Code\\app\\src\\main\\java\\com\\example\\myapplication\\amazonS3\\burn.png" ;
        //String sdcard = Environment.getExternalStorageDirectory().getPath();
        //String filepath = sdcard + "/Downloads/IMG_20200804_223356.jpg";

        //LocalDate today = LocalDate.now();
        List<String> health_attributes = new ArrayList<>();

        /*FitbitSummary fitbitSummary = FitbitPref.getInstance(this).getfitbitSummary();
        FitbitUser fitbitUser = FitbitPref.getInstance(this).getfitbitUser();

        health_attributes.add("ActivityDate");
        health_attributes.add("TotalSteps" + " " + fitbitSummary.getSteps().toString());
        health_attributes.add("TotalDistance");
        health_attributes.add("fairlyActiveMinutes" + " " + fitbitSummary.getFairlyActiveMinutes().toString());
        health_attributes.add("lightlyActiveMinutes" + " " + fitbitSummary.getLightlyActiveMinutes().toString());
        health_attributes.add("sedentaryMinutes" + " " + fitbitSummary.getSedentaryMinutes().toString());
        health_attributes.add("veryActiveMinutes" + " " + fitbitSummary.getVeryActiveMinutes().toString());
        health_attributes.add("activeScore" + " " + fitbitSummary.getActiveScore().toString());
        health_attributes.add("activityCalories" + " " + fitbitSummary.getActivityCalories().toString());
        health_attributes.add("caloriesBMR" + " " + fitbitSummary.getCaloriesBMR().toString());
        health_attributes.add("caloriesOut" + " " + fitbitSummary.getCaloriesOut().toString());
        health_attributes.add("marginalCalories" + " " + fitbitSummary.getMarginalCalories().toString());

        File file = new File(context.getFilesDir(), "sample3.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.append("Howdy World!");
        writer.close();*/

        // Initialize the Amazon Cognito credentials provider
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(
                context,
                "us-east-1:913d729e-fc5f-42cf-8057-572795207284", // Identity pool ID
                Regions.US_EAST_1 // Region
        );

        //File file = new File(this.getCacheDir(),"fitbitdata.csv");


        writedatatofile(bucketName,keyName,credentialsProvider,context);


    }
    private void writedatatofile(String bucketName, String keyName,CognitoCachingCredentialsProvider credentialsProvider,Context context)
    {
        try{
            File file = new File(context.getFilesDir(),"fitbitdata.csv");

            //OutputStream writer = new FileOutputStream(Environment.getExternalStorageDirectory().getAbsolutePath()+"/fitdata.csv");
            FileWriter writer = new FileWriter(file.getAbsoluteFile());
            //BufferedWriter bw = new BufferedWriter(fw);

            FitbitSummary fitbitSummary = FitbitPref.getInstance(this).getfitbitSummary();
            LoginResponse loginResponse = SharedPrefManager.getInstance(this).getLoginResponse();
            User user = SharedPrefManager.getInstance(this).getUser();

            StringBuilder newdata = new StringBuilder();
            newdata.append("auth_token");
            newdata.append(',');
            newdata.append("id");
            newdata.append(',');
            newdata.append("date");
            newdata.append(',');
            newdata.append("activeScore");
            newdata.append(',');
            newdata.append("activityCalories");
            newdata.append(',');
            newdata.append("caloriesBMR");
            newdata.append(',');
            newdata.append("caloriesOut");
            newdata.append(',');
            newdata.append("marginalCalories");
            newdata.append(',');
            newdata.append("steps");
            newdata.append(',');

            newdata.append("totaldistance");
            newdata.append(',');
            newdata.append("trackerdistance");
            newdata.append(',');

            newdata.append("loggedActivitiesdistance");
            newdata.append(',');
            newdata.append("moderateActivedistance");
            newdata.append(',');

            newdata.append("veryActivedistance");
            newdata.append(',');
            newdata.append("veryActiveMinutes");
            newdata.append(',');

            newdata.append("lightlyActivedistance");
            newdata.append(',');
            newdata.append("lightlyActiveMinutes");
            newdata.append(',');

            newdata.append("sedentaryActivedistance");
            newdata.append(',');
            newdata.append("sedentaryMinutes");
            newdata.append(',');

            newdata.append("restingHeartRate");
            newdata.append('\n');

            newdata.append(loginResponse.getAuth_token());
            newdata.append(',');
            newdata.append(user.getUser_id());
            newdata.append(',');
            newdata.append(Calendar.getInstance().getTime().toString());
            newdata.append(',');
            newdata.append(fitbitSummary.getActiveScore().toString());
            newdata.append(',');
            newdata.append(fitbitSummary.getActivityCalories().toString());
            newdata.append(',');
            newdata.append(fitbitSummary.getCaloriesBMR().toString());
            newdata.append(',');
            newdata.append(fitbitSummary.getCaloriesOut().toString());
            newdata.append(',');
            newdata.append(fitbitSummary.getMarginalCalories().toString());
            newdata.append(',');
            newdata.append(fitbitSummary.getSteps());
            newdata.append(',');

            newdata.append(fitbitSummary.getTotal());
            newdata.append(',');
            newdata.append(fitbitSummary.getTracker());
            newdata.append(',');


            newdata.append(fitbitSummary.getLoggedActivities());
            newdata.append(',');
            newdata.append(fitbitSummary.getModeratelyActive());
            newdata.append(',');

            newdata.append(fitbitSummary.getVeryActive());
            newdata.append(',');
            newdata.append(fitbitSummary.getVeryActiveMinutes());
            newdata.append(',');

            newdata.append(fitbitSummary.getLightlyActive());
            newdata.append(',');
            newdata.append(fitbitSummary.getLightlyActiveMinutes());
            newdata.append(',');

            newdata.append(fitbitSummary.getSedentaryActive());
            newdata.append(',');
            newdata.append(fitbitSummary.getSedentaryMinutes().toString());

            newdata.append("\n");

            writer.write(newdata.toString());
            writer.close();
            //Toast.makeText(this,"Done",Toast.LENGTH_LONG).show();

            System.out.println("complete");

        } catch (IOException e) {
            System.out.println(e.getMessage());
            //Toast.makeText(this,"Not Done",Toast.LENGTH_LONG).show();
        }
        AmazonS3 s3 = new AmazonS3Client(credentialsProvider);
        TransferUtility transferUtility = new TransferUtility(s3, context);
        TransferObserver observer = transferUtility.upload(
                bucketName,//this is the bucket name on S3
                keyName , //this is the path and name
                new File(context.getFilesDir(),"fitbitdata.csv") //path to the file locally
        );

    }
}


/*Ref:
https://aws.amazon.com/blogs/mobile/transfermanager-for-android/
 */

