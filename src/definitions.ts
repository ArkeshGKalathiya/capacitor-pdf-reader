declare module "@capacitor/core" {
  interface PluginRegistry {
    NGalaxyPDFReader: NGalaxyPDFReaderPlugin;
  }
}

export interface NGalaxyPDFReaderPlugin {
	openPDF(options: { value: string }): Promise<{value: string}>;
}
