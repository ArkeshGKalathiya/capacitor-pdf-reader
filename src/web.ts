import { WebPlugin } from '@capacitor/core';
import { NGalaxyPDFReaderPlugin } from './definitions';

export class NGalaxyPDFReaderWeb extends WebPlugin implements NGalaxyPDFReaderPlugin {
	
  constructor() {
    super({
      name: 'NGalaxyPDFReader',
      platforms: ['web']
    });
  }

  async openPDF(options: { pdfPath: string, title : string }): Promise<{value: string}> {
    return {value:""};
  }
}

const NGalaxyPDFReader = new NGalaxyPDFReaderWeb();

export { NGalaxyPDFReader };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(NGalaxyPDFReader);
