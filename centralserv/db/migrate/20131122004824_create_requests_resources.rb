class CreateRequestsResources < ActiveRecord::Migration
  def change
    create_table :requests_resources do |t|
      t.integer :resource_id
      t.integer :request_id
      t.text :response
    end
  end
end
