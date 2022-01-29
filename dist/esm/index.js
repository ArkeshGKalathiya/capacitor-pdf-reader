import { registerPlugin } from '@capacitor/core';
const NGalaxyPDFReader = registerPlugin('NGalaxyPDFReader', {
    web: () => import('./web').then(m => new m.NGalaxyPDFReaderWeb()),
});
export * from './definitions';
export { NGalaxyPDFReader };
//# sourceMappingURL=index.js.map