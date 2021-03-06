package com.netgalaxystudios.pdfreader;

import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class NGalaxyPDFReader extends Plugin {
	
    @PluginMethod()
    public void openPDF(PluginCall call) {

        String pdfPath = call.getString("pdfPath");
		String title = call.getString("title"); 

        JSObject ret = new JSObject();


        Intent intent = new Intent(getActivity().getBaseContext(), PDFViewActivity.class);
        intent.putExtra("pdfPath",pdfPath);
		intent.putExtra("title",title);
        getActivity().startActivity(intent);

        ret.put("value", title);
        call.success(ret);

    }
}
