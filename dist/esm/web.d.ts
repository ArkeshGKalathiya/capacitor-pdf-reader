import { WebPlugin } from '@capacitor/core';
import { NGalaxyPDFReaderPlugin } from './definitions';
export declare class NGalaxyPDFReaderWeb extends WebPlugin implements NGalaxyPDFReaderPlugin {
    constructor();
    openPDF(options: {
        pdfPath: string;
        title: string;
    }): Promise<{
        value: string;
    }>;
}
declare const NGalaxyPDFReader: NGalaxyPDFReaderWeb;
export { NGalaxyPDFReader };
