# Figma import guide (Tiny Tunes: Kids Piano)

## 1. Files
- `tokens.json` — color / font / radius / shadow / spacing tokens
- `design-tokens.css` — same tokens as CSS variables
- `logo.svg`, `tabs.svg`, `instruments.svg`, `buttons.svg`,
  `keys.svg`, `stars.svg` — UI components
- `animals/animal-*.svg` — 12 animal cards (200x230)

## 2. SVG -> Figma
Drag each SVG onto the canvas (or File > Place image). Each pastes as a
group — right-click > "Create component" to makeVariants
(e.g. tab active/inactive, instrument selected/unselected).
Emoji are `<text>` layers: they render with the system emoji font.
For production, replace emoji with vector illustrations.

## 3. Tokens -> Figma
Install the "Tokens Studio for Figma" plugin, create an empty token set,
paste the contents of `tokens.json` (JSONBin sync also works).
Or create Color Styles manually from the table in `tokens.json`.

## 4. Fonts
Install "Baloo 2" (Google Fonts, OFL license) before opening the SVGs,
otherwise Figma substitutes the font.

## 5. Frames / redlines
- Phone frame: 412x915 (tested) or 390x844 (iPhone 14).
- Content max-width 640, side padding 12.
- Keyboard: height 210, white keys flex-1 with bottom radius 14,
  black keys 76% width of one white key, 58% height, bottom radius 10.
- Background: vertical gradient #FFF7AD > #FFD1DC > #C5E8FF.
- Tab pills: height 56, radius 20, 3px brand-color border when inactive.
