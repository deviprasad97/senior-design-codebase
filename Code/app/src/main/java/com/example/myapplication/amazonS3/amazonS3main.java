package com.example.myapplication.amazonS3;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobileconnectors.s3.transfermanager.Upload;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.fitbitsample.fitbitdata.FitbitPref;
import com.fitbitsample.fitbitdata.FitbitSummary;
import com.fitbitsample.fitbitdata.FitbitUser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class amazonS3main extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void main() throws Exception {

        final String bucketName = "statefarmuta2020";
        final String keyName = "FitBitData";
        final String accessKey = "AKIAY25P2SXYFRBZZYG7";
        final String secretAccessKey = "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";
        final String file_path = "C:\\Users\\sbhad\\Documents\\SD_Project\\senior-design-codebase\\Code\\app\\src\\main\\java\\com\\example\\myapplication\\amazonS3\\text.txt";


        //LocalDate today = LocalDate.now();
        List<String> health_attributes = new ArrayList<>();

        FitbitSummary fitbitSummary = FitbitPref.getInstance(this).getfitbitSummary();
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

        AmazonS3 s3Client = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretAccessKey));
        s3Client.setRegion(Region.getRegion(Regions.US_EAST_1));

        //String bucket = "bucket name";
        //SimpleDateFormat td = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        //String currentDateandTime = td.format(new Date());
        //String key = currentDateandTime + getFileExtension(file);
        TransferUtility transferUtility = TransferUtility.builder().context(this).s3Client(s3Client).build();
        Upload uploadMedia = (Upload) transferUtility.upload(bucketName,keyName, new File(file_path));

        System.out.print("Success Upload");
        /*
        uploadMedia.setTransferListener(new TransferListener() {
                                            public void onStateChanged(int id, String newState) {
                                                // Do something in the callback.
                                            }

                                        });

         */
        /*
        try {
            AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretAccessKey);

            // TransferManager manages its own thread pool, so
            // please share it when possible.
            TransferManager manager = new TransferManager(awsCredentials);

            // Transfer a file to an S3 bucket.
            Upload upload = manager.upload(bucketName, keyName, new File(file_path));


            System.out.println("Object upload started");

            upload.waitForCompletion();
            System.out.println("Object upload complete");
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {

            e.printStackTrace();
        }

         */

    }
}


/*Ref:
https://aws.amazon.com/blogs/mobile/transfermanager-for-android/
 */

