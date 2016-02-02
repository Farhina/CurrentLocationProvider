package com.example.lynxit.currentlocationprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.location.Geocoder;
import android.net.Uri;
import android.support.annotation.Nullable;

import java.util.Locale;

/**
 * Created by farhina on 2/02/2016.
 */
public class GeoLocationProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.lynxit.currentlocationprovider";
    private static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY);
    private static final int LATLONG = 0;
    private static final UriMatcher uriMatcher = getUriMatcher();
    private static UriMatcher getUriMatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"latlong",LATLONG);
        return uriMatcher;
    }
    @Override
    public boolean onCreate() {
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        String[] columns = {"latitude","longitude"};

        MatrixCursor matrixCursor = new MatrixCursor(columns);


         matrixCursor.newRow().add(columns[0],"-70.5").add(columns[1],"20");

        return matrixCursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case LATLONG:
                return "success";
        }
        return "";
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
