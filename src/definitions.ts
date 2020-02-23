declare module "@capacitor/core" {
  interface PluginRegistry {
    NGalaxyPDFReader: NGalaxyPDFReaderPlugin;
  }
}

export interface NGalaxyPDFReaderPlugin {
	openPDF(options: { pdfPath: string, title : string }): Promise<{value: string}>;
}
