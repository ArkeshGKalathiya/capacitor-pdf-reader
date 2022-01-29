# netgalaxy-pdf-reader

Pdf Reader with bookmark list

## Install

```bash
npm install netgalaxy-pdf-reader
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`openPDF(...)`](#openpdf)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### openPDF(...)

```typescript
openPDF(options: { pdfPath: string; title: string; }) => Promise<{ value: string; }>
```

| Param         | Type                                             |
| ------------- | ------------------------------------------------ |
| **`options`** | <code>{ pdfPath: string; title: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------

</docgen-api>
