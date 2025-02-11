import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
    plugins: [react()],
    build: {
        sourcemap: true,
        rollupOptions: {
            input: {
                App: 'src/jsx/App.jsx',
            },
            output: {
                dir: 'src/main/webapp/resources/script',
                entryFileNames: '[name].js',
                format: 'iife',
            }
        }
    }
})
