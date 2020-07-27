package com.fitbitsample.network;


public class NetworkErrorDialog  {
    /*private Context context;
    private DialogNetworkErrorBinding dialogNetworkErrorBinding;
    private List<NetworkError> errors;
    private NetworkErrorListener networkErrorListener;

    public NetworkErrorDialog(Context context, List<NetworkError> errors, NetworkErrorListener networkErrorListener) {
        super(context);
        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);
        this.context = context;
        this.errors = errors;
        this.networkErrorListener = networkErrorListener;
    }

    public NetworkErrorDialog(Context context, List<NetworkError> errors) {
        super(context);
        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);
        this.context = context;
        this.errors = errors;
        this.networkErrorListener = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogNetworkErrorBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_network_error, null, false);
        setContentView(dialogNetworkErrorBinding.getRoot());
        NetworkError error;
        if (errors.size() > 0) {
            if (errors.size() == 1) {
                error = new NetworkError(errors.get(0).getDescription(), errors.get(0).getRecommendation());
            } else {
                String errorString = "";
                for (NetworkError networkError : errors) {
                    errorString += "\n" + StringUtil.fixString(networkError.getDescription()) + "\n" + StringUtil.fixString(networkError.getRecommendation()) + "\n";
                }
                error = new NetworkError(context.getString(R.string.error), errorString);
            }
        } else {
            error = new NetworkError(context.getString(R.string.error), context.getString(R.string.something_went_wrong_error));
        }
        dialogNetworkErrorBinding.setNetworkError(error);
        dialogNetworkErrorBinding.setCallback(dialogListener);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        dialogListener = null;
        dialogNetworkErrorBinding = null;
    }

    private DialogListener dialogListener = new DialogListener() {
        @Override
        public void ok() {
            if (networkErrorListener != null) {
                networkErrorListener.ok();
            }
            dismiss();
        }

        @Override
        public void cancel() {
            dismiss();
        }
    };*/
}