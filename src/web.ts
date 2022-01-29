import { WebPlugin } from '@capacitor/core';

import type { NGalaxyPDFReaderPlugin } from './definitions';

export class NGalaxyPDFReaderWeb
  extends WebPlugin
  implements NGalaxyPDFReaderPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async openPDF(options: { pdfPath: string, title: string }): Promise<{ value: string }> {
    console.log(options);
    return { value: "" };
  }
}
