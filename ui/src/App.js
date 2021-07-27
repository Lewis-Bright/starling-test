import { HomePage } from './components/homepage/HomePage'
import { QueryClient, QueryClientProvider } from 'react-query'
import './App.css';
import { createTheme, ThemeProvider } from '@material-ui/core/styles';

const theme = createTheme({
  palette: {
    primary: {
      main: '#192851',
    },
    secondary: {
      main: '#ffffff',
    },
  },
});

const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retryDelay: 1,
      retry:0,
    },
  },
})

function App() {
  return (
    <ThemeProvider theme={theme}>
      <QueryClientProvider client={queryClient}>
        <HomePage />
      </QueryClientProvider >
    </ThemeProvider>
  );
}

export default App;
