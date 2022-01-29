export interface NGalaxyPDFReaderPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  openPDF(options: { pdfPath: string, title: string }): Promise<{ value: string }>;
}
