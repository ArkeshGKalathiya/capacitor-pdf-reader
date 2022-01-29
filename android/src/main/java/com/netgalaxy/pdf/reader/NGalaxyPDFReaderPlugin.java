package com.netgalaxy.pdf.reader;

import android.content.Intent;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "NGalaxyPDFReader")
public class NGalaxyPDFReaderPlugin extends Plugin {

    private NGalaxyPDFReader implementation = new NGalaxyPDFReader();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

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
        call.resolve(ret);

    }
}
