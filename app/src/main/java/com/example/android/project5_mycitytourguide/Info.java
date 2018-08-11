package com.example.android.project5_mycitytourguide;


/**
 * {@link Info} represents a info that the user wants to visit.
 * It contains name and description of place.
 */
public class Info {

    /** Name of the place */
    private String mName;

    /** Details of the place*/
    private String mDetails;

//    /** Address of the place*/
//    private String mAddress;

    /** Address resource ID for the place */
    private String mAddress = NO_ADDRESS_PROVIDED;

    /** Constant value that represents no address was provided for this place */
    private static final String NO_ADDRESS_PROVIDED = String.valueOf(-1);

    /** Image resource ID for the place */
    private int mImageResourceId;


    /**
     * Create a new Info object.
     *
     * @param name is the name of the place
     *
     * @param details is the details of the place
     *
     * @param imageResourceId is the image of the place
     */
    public Info(String name, String details, int imageResourceId) {
        mName = name;
        mDetails = details;
        mImageResourceId = imageResourceId;
    }


    /**
     * Create a new Info object.
     *
     * @param name is the name of the place
     *
     * @param details is the details of the place
     *
     * @param address is the location of the place
     *
     * @param imageResourceId is the image of the place
     */
    public Info(String name, String details, String address, int imageResourceId) {
        mName = name;
        mDetails = details;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the place.
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the details of the place.
     */
    public String getDetails() {
        return mDetails;
    }

    /**
     * Get the location of the place.
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Returns whether or not there is an address info for this item.
     */
    public boolean hasAddress(){
        return mAddress != NO_ADDRESS_PROVIDED;
    }

    /**
     * Return the image resource ID of the place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public String toString(){
        return "Info{" +
                "mName='" + mName +'\'' +
                "mDetails" + mDetails +'\'' +
                "mAddress" + mAddress +
                "mImageResourceId" + mImageResourceId +
                '}';
    }
}
