import { WebPlugin } from '@capacitor/core';
import type { NGalaxyPDFReaderPlugin } from './definitions';
export declare class NGalaxyPDFReaderWeb extends WebPlugin implements NGalaxyPDFReaderPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    openPDF(options: {
        pdfPath: string;
        title: string;
    }): Promise<{
        value: string;
    }>;
}
