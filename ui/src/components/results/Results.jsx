import { QueryClient, QueryClientProvider, useQuery } from 'react-query'
import axios from 'axios';

const queryClient = new QueryClient()

export const Results = (props) => {
  const { isLoading, error, data } = useQuery('savingsGoalSummary', () => {
    const { data } = await axios.post('http://localhost:8080/savings', { apiKey: props.apiKey });
    return data;
  });

  if (isLoading) return 'Loading...'

  if (error) return 'An error has occurred: ' + error.message

  return (
    <div>
      <p>You've saved £{data.total}</p>
    </div>
  );
};