declare module "@capacitor/core" {
    interface PluginRegistry {
        NGalaxyPDFReader: NGalaxyPDFReaderPlugin;
    }
}
export interface NGalaxyPDFReaderPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
