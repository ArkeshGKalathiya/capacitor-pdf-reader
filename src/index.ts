import { registerPlugin } from '@capacitor/core';

import type { NGalaxyPDFReaderPlugin } from './definitions';

const NGalaxyPDFReader = registerPlugin<NGalaxyPDFReaderPlugin>(
  'NGalaxyPDFReader',
  {
    web: () => import('./web').then(m => new m.NGalaxyPDFReaderWeb()),
  },
);

export * from './definitions';
export { NGalaxyPDFReader };
